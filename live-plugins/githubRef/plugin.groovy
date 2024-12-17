import com.intellij.openapi.actionSystem.AnActionEvent

import static liveplugin.PluginUtil.*

String githubRef(String str) {
    String user = "stal";
    if (str.startsWith("C:/repos/")) {
        // my dev machine, my private GH, one level of hierarchy
        String repo = str.substring("C:/repos/".length(), str.indexOf('/', "C:/repos/".length()+1));
        return str.replace("C:/repos/", "https://github.com/shahart/" + repo + "/blob/master/").replace("/blob/master/" + repo, "/blob/master");
    }
    // for Linux, or two levels of hierarchy like github.com/module/sub-module/...
    String repo = str.substring(("/Users/" + user + "/repos/").length()-1, str.indexOf('/', ("/Users/" + user + "/repos/").length()+1));
    repo = repo + str.substring(("/Users/" + user + "/repos" + repo).length(), str.indexOf('/', ("/Users/" + user + "/repos/" + repo +"/").length()+1));
    str =  str.replace("/Users/" + user + "/repos/", "https://github.com" + repo + "/blob/master/").replace("/blob/master" + repo, "/blob/master");
    return str;
}

registerAction("githubRef", "alt shift H") { AnActionEvent event ->
    var psiFile = event.getData(com.intellij.openapi.actionSystem.CommonDataKeys.VIRTUAL_FILE)
    var path= psiFile?.canonicalPath
    show("githubRef: " + githubRef(path))
}

if (!isIdeStartup) show("Loaded 'githubRef'<br/>Use Alt/Option + Shift + H to run it")
