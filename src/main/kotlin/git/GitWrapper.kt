package git

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

final class GitWrapper {

    companion object {
        private val singleton = GitWrapper()

        fun getInstance(): GitWrapper {
            return singleton
        }
    }

    private val shell: Array<String>

    init {
        val os = System.getProperty("os.name").lowercase()
        this.shell = if(os.contains("win")) arrayOf("cmd.exe", "/c")
            else arrayOf("bash", "-c")
    }

    private fun execute(cmd: String): String {
        val processBuilder = ProcessBuilder()
        processBuilder.command(*shell, cmd)

        val process = processBuilder.start()
        val reader = BufferedReader(InputStreamReader(process.inputStream))

        while(process.isAlive) { Thread.sleep(100) }
        process.waitFor()

        val response = reader.readLines().joinToString("\n")
        process.destroy()

        return response
    }

    public fun executeWithInteractive(cmd: String) {
        val processBuilder = ProcessBuilder()
        processBuilder.command(*shell, cmd)

        processBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT)
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)

        val process = processBuilder.start()
        process.waitFor()
    }

    public fun push(force: Boolean = false): String {
        val result = if(force) execute("git push --force origin")
        else execute("git push origin")

        return result
    }

    public fun commit(title: String, description: String? = null): String {
        return if(description != null) execute("git commit -m \"${title}\" -m \"${description}\"")
            else execute("git commit -m \"${title}\"")
    }

    public fun getCurrentBranch(): String {
        return execute("git branch").split(" ").last()
    }

    public fun addAll() {
        execute("git add --all")
    }

    public fun addWithModal() {
        executeWithInteractive("git add -p")
    }

    public fun createBranch(branchName: String) {
        execute("git branch $branchName")
    }

    public fun checkout(to: String): String {
        return execute("git checkout $to")
    }


}