/*
  Title: Default Java Script

 */

var IOS_API_PREFIX = "jsCall"

function iosAPI(groupId, methodId, parameter) {
    try {
        if (!methodId) {
            return;
        }

        // make a command
        var command = IOS_API_PREFIX + ":";

        // group & method
        if (groupId) {
            command += groupId + ":" + methodId + "(";

        } else {
            command += methodId + "(";
        }

        // parameter
        if (parameter) {
            command += "'" + parameter + "'";
        }

        command += ");";

        alert(command);

        // call
        webkit.messageHandlers.spiderCallback.postMessage(command);
        // webkit.messageHandlers.AlioCallback.postMessage(command);

    } catch(err) {
        alert(err);
    }
}