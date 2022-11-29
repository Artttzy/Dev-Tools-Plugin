package com.plugin.plugplugplug;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.actionSystem.EditorAction;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorWriteActionHandler;
import com.intellij.openapi.util.TextRange;

public class ChangeCodeToLOL extends EditorAction {

    public ChangeCodeToLOL(EditorActionHandler defaultHandler) {
        super(defaultHandler);
    }

    public ChangeCodeToLOL() {
        this(new LolHandler());
    }

    private static class LolHandler extends EditorWriteActionHandler {
        private LolHandler() {
        }

        @Override
        public void executeWriteAction(Editor editor, DataContext dataContext) {
            Document document = editor.getDocument();

            if (!document.isWritable()) {
                return;
            }

            CaretModel caretModel = editor.getCaretModel();
            SelectionModel selectionModel = editor.getSelectionModel();


            TextRange charsRange = new TextRange(selectionModel.getSelectionStart(), selectionModel.getSelectionEnd());

            document.replaceString(charsRange.getStartOffset(), charsRange.getEndOffset(), "LOL");


            caretModel.moveToOffset(charsRange.getStartOffset());
            editor.getScrollingModel().scrollToCaret(ScrollType.RELATIVE);
        }
    }
}