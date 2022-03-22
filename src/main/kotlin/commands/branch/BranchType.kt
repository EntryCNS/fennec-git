package commands.branch

enum class BranchType(val prefix: String) {
    FEATURE("Feature"),
    HOTFIX("Hotfix"),
    RELEASE("Release")
}