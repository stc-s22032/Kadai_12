package s22032.suntech.jp.kadai_12;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
//import androidx.appcompat.app.AlertDialog;
import androidx.annotation.Nullable;

public class ConfirnDialogFrament extends DialogFragment {
    @NonNull
    //@Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setTitle("内容確認");
        builder.setMessage("送信しますか？");
        builder.setPositiveButton("送信",new DialogButtonClickListener());
        builder.setNegativeButton("キャンセル",new DialogButtonClickListener());

        AlertDialog dialog = builder.create();
        return dialog;

    }
    private class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int which){
            String msg = "";
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg = "送信しました";
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    msg = "キャンセルしました";
                    break;
            }
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        }
    }
}
