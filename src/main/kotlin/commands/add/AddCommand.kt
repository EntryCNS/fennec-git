package commands.add

import commands.ArgumentType
import commands.FennecArgument
import commands.FennecCommand
import git.GitWrapper

class AddCommand: FennecCommand() {
    override fun getName(): String = "add"

    override fun getDescription(): String = "커밋할 파일을 추가합니다"

    override fun getRequiredArguments(): List<FennecArgument> = listOf(
        FennecArgument("업로드할 방식", listOf(ArgumentType.ENUM_ADDTYPE), true),
    )

    override fun run(arguments: List<String>) {
        val addType = try { AddType.valueOf(arguments[0]) } catch (ex: Exception) { AddType.CHOOSE }

        val gitWrapper = GitWrapper.getInstance()

        // git add
        when(addType) {
            AddType.ALL -> gitWrapper.addAll()
            AddType.CHOOSE -> gitWrapper.addWithModal()
        }
    }

}