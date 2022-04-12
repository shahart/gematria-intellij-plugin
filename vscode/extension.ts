/* `yo code`. Choose the 1st option: new TS extension.

package.json:

	"activationEvents": [ "onCommand:gematria.Gematria"
	"contributes": {
		"commands": [ {
			"command": "gematria.Gematria",
			"title": "gematria calc"

F5 for testing: Select text and hit Ctrl-Shift-P to choose Gematria

Conclude with `vsce package`

*/

import * as vscode from 'vscode';

export function activate(context: vscode.ExtensionContext) {
	let disposable = vscode.commands.registerTextEditorCommand('gematria.Gematria', () => {
		var editor = vscode.window.activeTextEditor;
		if (!editor) {
			return;
		}
		var str = editor.document.getText(editor.selection);
		let sum = 0;
		const aleph = 1488;
		for (let i = 0; i < str.length; ++ i) {
		  if (str.charCodeAt(i) >= aleph && str.charCodeAt(i) <= (aleph+10-1)) {
			sum += str.charCodeAt(i) - (aleph-1);
		  }
		  else if (str.charCodeAt(i) === aleph+10 || str.charCodeAt(i) === aleph+11) {
			sum += 20;
		  }
		  else if (str.charCodeAt(i) === aleph+12) {
			sum += 30;
		  }
		  else if (str.charCodeAt(i) === aleph+13 || str.charCodeAt(i) === aleph+14) {
			sum += 40;
		  }
		  else if (str.charCodeAt(i) === aleph+15 || str.charCodeAt(i) === aleph+16 || str.charCodeAt(i) === 1487) {
			sum += 50;
		  }
		  else if (str.charCodeAt(i) === aleph+17) {
			sum += 60;
		  }
		  else if (str.charCodeAt(i) === aleph+18) {
			sum += 70;
		  }
		  else if (str.charCodeAt(i) === aleph+19 || str.charCodeAt(i) === aleph+20) {
			sum += 80;
		  }
		  else if (str.charCodeAt(i) === aleph+21 || str.charCodeAt(i) === aleph+22) {
			sum += 90;
		  }
		  else if (str.charCodeAt(i) >= aleph+23 && str.charCodeAt(i) <= aleph+23+4-1) {
			sum += 100 * (str.charCodeAt(i) - (aleph+23) + 1);
		  }
		}
		vscode.window.showInformationMessage('Gematria: ' + sum);
	});
	context.subscriptions.push(disposable);
}

export function deactivate() {}
