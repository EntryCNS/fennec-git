package commands.upload

enum class CommitType(val emoji: String) {
    CREATE("\uD83D\uDCA5::"),
    FEATURE("\uD83D\uDD8B️::"),
    BUG("\uD83D\uDD27::"),
    DELETE("⚰️::"),
    REFACTOR("♻️::"),
    SETUP("⚙️::"),
    DOCS("\uD83D\uDCDD::"),
    TEST("\uD83E\uDDEA::")
}