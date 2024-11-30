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
    String vals = "";

    Notifications.Bus.notify(new Notification("gematria", "Gematria", vals + (Calc.calc(str)), NotificationType.INFORMATION));

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
