package kz.sirius.myapplication.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kz.sirius.myapplication.R;

public class KirillsViewHolder extends RecyclerView.ViewHolder {

    TextView uiNiceText;

    public KirillsViewHolder(@NonNull View itemView) {
        super(itemView);

        uiNiceText = itemView.findViewById(R.id.uiHolderText);
    }

    /*public void bind(YourClass object) {
        uiNiceText.setText();

    }*/
}
