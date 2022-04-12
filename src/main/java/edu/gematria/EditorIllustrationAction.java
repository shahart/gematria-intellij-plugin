// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package edu.gematria;

import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;

public class EditorIllustrationAction extends AnAction {

  @Override
  public void actionPerformed(@NotNull final AnActionEvent e) {
    // Get all the required data from data keys
    // Editor and Project were verified in update(), so they are not null.
    final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
    final Document document = editor.getDocument();
    // Work off of the primary caret to get the selection info
    Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
    int start = primaryCaret.getSelectionStart();
    int end = primaryCaret.getSelectionEnd();

    String str = document.getText(new TextRange(start, end));
    int sum = 0;
    String vals = "";
    for (int i = 0; i < str.length(); ++ i) {
      // vals += String.valueOf((int)str.charAt(i)) + " ";
      // Aleph's unicode
      if ((int)str.charAt(i) >= 1488 && (int)str.charAt(i) <= (1488+10-1)) {
        // vals += "* ";
        sum += (int)str.charAt(i) - (1488-1);
      }
      else if ((int)str.charAt(i) == 1488+10 || (int)str.charAt(i) == 1488+11) {
        sum += 20;
      }
      else if ((int)str.charAt(i) == 1488+12) {
        sum += 30;
      }
      else if ((int)str.charAt(i) == 1488+13 || (int)str.charAt(i) == 1488+14) {
        sum += 40;
      }
      else if ((int)str.charAt(i) == 1488+15 || (int)str.charAt(i) == 1488+16 || (int)str.charAt(i) == 1487 /* U+05C6 Hebrew Punctuation Nun Hafukha */ ) {
        sum += 50;
      }
      else if ((int)str.charAt(i) == 1488+17) {
        sum += 60;
      }
      else if ((int)str.charAt(i) == 1488+18) {
        sum += 70;
      }
      else if ((int)str.charAt(i) == 1488+19 || (int)str.charAt(i) == 1488+20) {
        sum += 80;
      }
      else if ((int)str.charAt(i) == 1488+21 || (int)str.charAt(i) == 1488+22) {
        sum += 90;
      }
      else if ((int)str.charAt(i) >= 1488+23 && (int)str.charAt(i) <= 1488+23+4-1) {
        sum += 100 * ((int)str.charAt(i) - (1488+23) + 1);
      }
    }

    Notifications.Bus.notify(new Notification("gematria", "Gematria", vals + String.valueOf(sum), NotificationType.INFORMATION));

    // De-select the text range that was just replaced
    primaryCaret.removeSelection();
  }

  /**
   * Sets visibility and enables this action menu item if:
   * <ul>
   *   <li>a project is open</li>
   *   <li>an editor is active</li>
   *   <li>some characters are selected</li>
   * </ul>
   *
   * @param e Event related to this action
   */
  @Override
  public void update(@NotNull final AnActionEvent e) {
    // Get required data keys
    final Project project = e.getProject();
    final Editor editor = e.getData(CommonDataKeys.EDITOR);
    // Set visibility and enable only in case of existing project and editor and if a selection exists
    e.getPresentation().setEnabledAndVisible(
            project != null && editor != null && editor.getSelectionModel().hasSelection()
    );
  }

}
