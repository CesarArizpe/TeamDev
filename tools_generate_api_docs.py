from pathlib import Path
import re, html
ROOT = Path(__file__).parent
SRC = ROOT / 'src'
OUT = ROOT / 'docs' / 'api'
OUT.mkdir(parents=True, exist_ok=True)
files = sorted(SRC.rglob('*.java'))
classes=[]
for p in files:
    text=p.read_text(encoding='utf-8')
    m=re.search(r'(?m)^public\s+(?:abstract\s+)?class\s+(\w+)', text)
    if not m: continue
    name=m.group(1)
    pkgm=re.search(r'(?m)^package\s+([\w.]+)\s*;', text)
    pkg=pkgm.group(1) if pkgm else '(default package)'
    docm=re.search(r'/\*\*(.*?)\*/\s*public\s+(?:abstract\s+)?class\s+'+re.escape(name), text, re.S)
    description=''
    if docm:
        description=' '.join(line.strip().lstrip('*').strip() for line in docm.group(1).splitlines()).strip()
    methods=[]
    # Public/protected method/constructor signatures, collecting multi-line signatures through opening brace or semicolon.
    lines=text.splitlines()
    i=0
    while i < len(lines):
        line=lines[i]
        if re.match(r'^\s*(public|protected)\s+', line) and ('(' in line) and not line.lstrip().startswith('//'):
            sig=line.strip(); j=i
            while not ('{' in sig or ';' in sig) and j+1<len(lines):
                j+=1; sig += ' ' + lines[j].strip()
            sig=sig.rstrip('{;').strip()
            # Exclude field declarations and lambda-looking content
            if '(' in sig and ')' in sig and not sig.startswith(('public class','public abstract class')):
                sig=re.sub(r'\s+', ' ', sig)
                mm=re.search(r'\b([A-Za-z_$][\w$]*)\s*\(', sig)
                meth=mm.group(1) if mm else ''
                # nearest preceding Javadoc if present
                prior='\n'.join(lines[max(0,i-8):i])
                desc='Public API member.'
                dm=re.search(r'/\*\*(.*?)\*/\s*$', prior, re.S)
                if dm:
                    desc=' '.join(x.strip().lstrip('*').strip() for x in dm.group(1).splitlines()).strip()
                methods.append((sig,desc,meth))
            i=j
        i+=1
    classes.append({'name':name,'pkg':pkg,'path':p.relative_to(SRC).as_posix(),'desc':description,'methods':methods})

css='''body{font-family:Arial,Helvetica,sans-serif;line-height:1.5;max-width:1100px;margin:2rem auto;padding:0 1.2rem;color:#202124}h1,h2,h3{line-height:1.2}a{color:#1558a6}nav{background:#f3f5f7;padding:.8rem 1rem;border-radius:6px}code,pre{font-family:Consolas,monospace}code{background:#f2f2f2;padding:.1rem .25rem;border-radius:3px}.member{border-top:1px solid #ddd;padding:.7rem 0}.sig{white-space:pre-wrap;background:#f7f7f7;padding:.6rem;border-radius:4px}.muted{color:#5f6368}.classlist li{margin:.35rem 0}'''
(OUT/'style.css').write_text(css,encoding='utf-8')

def page(title, body):
    return '<!doctype html><html lang="en"><head><meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>'+html.escape(title)+'</title><link rel="stylesheet" href="style.css"></head><body>'+body+'</body></html>'

items=[]
for c in classes:
    filename=c['name']+'.html'
    body=f'<nav><a href="index.html">API Index</a> / {html.escape(c["pkg"])}</nav><h1>{html.escape(c["name"])}</h1><p class="muted">Package: <code>{html.escape(c["pkg"])}</code> · Source: <code>{html.escape(c["path"])}</code></p><p>{html.escape(c["desc"] or "No class description was present in the source.")}</p><h2>Public and protected members</h2>'
    if not c['methods']:
        body += '<p>No public/protected methods were detected.</p>'
    for sig,desc,meth in c['methods']:
        body += '<section class="member"><div class="sig"><code>'+html.escape(sig)+'</code></div><p>'+html.escape(desc or 'Public API member.')+'</p></section>'
    (OUT/filename).write_text(page(c['name']+' API',body),encoding='utf-8')
    items.append(f'<li><a href="{filename}"><code>{html.escape(c["name"])}</code></a> <span class="muted">— {html.escape(c["pkg"])}</span><br>{html.escape(c["desc"][:220])}</li>')
index='<nav>Java Chess GUI Prototype · API Reference</nav><h1>API Documentation</h1><p>This HTML reference is generated from the project source files and their Javadoc comments. For the official Javadoc tool output, use the command in the project README on a machine with the configured JavaFX SDK.</p><h2>Classes</h2><ul class="classlist">'+''.join(items)+'</ul><h2>Package overview</h2><ul><li><code>includes.chessBoard</code> — board and square state</li><li><code>includes.chessPieces</code> — piece hierarchy, move generation, and GUI selection behavior</li><li><code>(default package)</code> — JavaFX entry points</li></ul>'
(OUT/'index.html').write_text(page('Java Chess API Documentation',index),encoding='utf-8')
print(f'Generated {len(classes)} class pages in {OUT}')
