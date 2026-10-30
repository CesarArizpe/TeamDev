# Java Chess GUI Prototype

## Project overview

This project is a JavaFX graphical prototype for a two-player chess application. It renders an 8 × 8 board, displays piece sprites, provides selectable white and black piece options, highlights candidate destination squares, and contains a piece hierarchy for the six standard chess piece types. `ChessTester` is the recommended entry point for the current interactive prototype.

This is a Phase 1 development prototype, not a complete tournament-rules chess engine. The current `ChessTester` setup starts with an empty board so pieces can be placed from the selection shelves. It is intended to support development and demonstration of the board, piece, and interaction classes.

## Requirements

- Windows is recommended because the current sprite paths and batch script use Windows-style paths.
- A JDK compatible with the installed JavaFX SDK (the current project setup uses JDK 25 and JavaFX SDK 27).
- JavaFX SDK modules `javafx.controls` and `javafx.media` available on the module path. The visible prototype primarily uses JavaFX controls/graphics; the existing batch script includes `javafx.media` as configured in the project.

## Run the prototype

1. Install a JDK and download/extract a matching JavaFX SDK.
2. Open the project root (the directory containing `src` and `chessTester.bat`) in VS Code or a terminal.
3. Open `chessTester.bat` and update the JavaFX SDK paths if your SDK is not located at `C:\Users\Cesar\javafx-sdk-27`.
4. Run `chessTester.bat` from File Explorer or a Command Prompt. The script compiles Java files from `src` into `out` and launches `ChessTester`.

The equivalent commands, after adjusting the SDK path, are:

```bat
if not exist out mkdir out
dir /s /b src\*.java > sources.txt
javac --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media -d out @sources.txt
java --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media --enable-native-access=javafx.graphics -Djava.library.path="C:\Users\Cesar\javafx-sdk-27\bin" -cp out ChessTester
```

Run these commands from the project root so the relative sprite paths resolve. `ChessTester` loads sprites from `src\includes\sprites`. `App` is an alternate experimental entry point and currently contains a machine-specific absolute path; use `ChessTester` for the submitted prototype unless that path has been updated.

## Project structure

```text
src/
├── App.java                         # Alternate/experimental JavaFX entry point
├── ChessTester.java                 # Recommended JavaFX prototype entry point
└── includes/
    ├── chessBoard/
    │   ├── ChessBoard.java           # Board state and board operations
    │   ├── GridSpace.java            # Board square model and JavaFX shapes
    │   └── ChessBoardTester.java     # Earlier board-testing class
    ├── chessPieces/
    │   ├── Piece.java                # Abstract piece base class
    │   ├── Pawn.java, Rook.java, ... # Shared piece movement implementations
    │   ├── White*.java, Black*.java  # Color-specific piece classes
    │   ├── SelectionManager.java     # GUI interaction and move highlighting
    │   ├── SelectionGenerator.java   # Piece options shown beside the board
    │   └── Thing.java                # Legacy/experimental UI abstraction
    └── sprites/                      # White and black piece PNG images

docs/api/index.html                  # HTML API documentation entry point
docs/api/                            # Class reference pages
```

## Implemented prototype features

- JavaFX rendering of an 8 × 8 chessboard.
- Sprite images for white and black pawns, rooks, knights, bishops, queens, and kings.
- Shared abstract `Piece` hierarchy and color-specific subclasses.
- Selection shelf for choosing piece types and colors.
- Mouse interaction for selecting pieces, showing candidate moves, moving pieces, and capturing opposing pieces in supported workflows.
- Board state operations for placing pieces, moving pieces, and removing captured-piece display nodes.
- Optional turn-based interaction flag.

## Known limitations

- The main `ChessTester` board is empty at startup; a standard starting position is not automatically arranged.
- This is a prototype, and movement/validation should be tested for every piece and edge case before describing the game as fully rules-complete. In particular, verify basic one-square king movement, turn ownership, blocked paths, pawn edge cases, and that invalid moves do not alter board state or switch turns.
- Check, checkmate, stalemate, castling, en passant, pawn promotion, and king-safety/check restrictions are not implemented as a complete rules system. These are intentionally outside the current prototype scope; pawn behavior on the last rank is not a complete promotion workflow.
- The board's low-level `addPiece`, `movePiece`, and `capturePiece` methods are state/display operations and do not independently enforce every chess rule. Validation belongs in the calling interaction and piece logic.
- The `App` entry point uses a hard-coded absolute sprite path. The recommended `ChessTester` entry point uses a project-relative path, but the project should be launched from its root directory.
- Some debugging output remains in the console, and the project does not currently include a comprehensive automated test suite.

## Testing / demonstration checklist

When demonstrating the prototype, record expected and observed results for successful moves and captures as well as invalid/boundary cases. Suggested checks:

1. Place each color and piece type on the board.
2. Select a piece and confirm candidate destination squares are highlighted.
3. Make a legal move and verify the piece and board state update.
4. Capture an opposing piece and verify the captured sprite is removed.
5. Attempt to move an opponent's piece during the other side's turn.
6. Test moves outside a piece's movement pattern, blocked sliding-piece paths, friendly-piece destinations, and board-edge pawn moves.
7. Confirm rejected moves do not change the board state or current turn.

The last checks should be reported as passing only after they have been run; this README does not claim every case is already passing.

## API documentation

Open [`docs/api/index.html`](docs/api/index.html) in a browser for the class reference. Source files also include Javadoc comments for the main model, movement, and interaction classes.

To regenerate official Javadoc on Windows with the JavaFX SDK installed, run this from the project root (adjust the SDK path as needed):

```bat
javadoc -Xdoclint:none --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media -sourcepath src -d docs\api src\App.java src\ChessTester.java -subpackages includes.chessBoard:includes.chessPieces
```

Review the generated documentation after regeneration, and ensure `docs\api\index.html` is included in the submission.

## Submission notes

Include the accessible GitHub repository URL in the project report. The report should contain a project summary, UML diagram, screenshots of successful workflows and invalid/boundary tests with expected and observed outcomes, and the required AI-use disclosure. Add your own name/team information and repository URL before submission.
