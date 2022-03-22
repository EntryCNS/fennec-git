package commands.branch.create

import commands.ArgumentType
import commands.FennecArgument
import commands.FennecCommand
import commands.branch.BranchType
import git.GitWrapper

class CreateBranchCommand: FennecCommand() {
    override fun getName(): String = "flow"

    override fun getDescription(): String = "새 gitflow 브랜치를 생성합니다"

    override fun getRequiredArguments(): List<FennecArgument> = listOf(
        FennecArgument("브랜치 종류", listOf(ArgumentType.ENUM_BRANCHTYPE)),
        FennecArgument("이슈번호", listOf(ArgumentType.NUMBER)),
        FennecArgument("제목", listOf(ArgumentType.STRING))
    )

    override fun run(arguments: List<String>) {
        val branchPrefix = BranchType.valueOf(arguments[0]).prefix
        val issueNumber = arguments[1].toInt()
        val dashedBranchName = arguments[2].lowercase().replace(" ", "-")

        val branchName = "$branchPrefix/$issueNumber-$dashedBranchName"

        val gitWrapper = GitWrapper.getInstance()
        gitWrapper.createBranch(branchName)
        gitWrapper.checkout(branchName)

        println("You're now on: ${branchName}")
    }
}