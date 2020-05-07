package kz.sirius.myapplication.viewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.VadimItem;

public class VadimsViewHolder extends RecyclerView.ViewHolder {
    TextView uiTaskTitleText;
    Button uiDoTaskButton;
    TextView uiTaskDateText;

    public VadimsViewHolder(@NonNull View itemView) {
        super(itemView);
        uiTaskTitleText = itemView.findViewById(R.id.uiTaskTitleText);
        uiDoTaskButton = itemView.findViewById(R.id.uiDoTaskButton);
        uiTaskDateText = itemView.findViewById(R.id.uiTaskDateText);
    }

    public void bind(VadimItem object) {
        uiTaskTitleText.setText(object.getTitle());
        uiDoTaskButton.setText("Выполнить задачу");
        uiTaskDateText.setText(object.getDate().toString());
//        Calendar.getInstance().getTime().toString()
    }
}
