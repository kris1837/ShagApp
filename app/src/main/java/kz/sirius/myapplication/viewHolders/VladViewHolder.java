package kz.sirius.myapplication.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.VladItem;

public class VladViewHolder extends RecyclerView.ViewHolder {

    public TextView uiVladNiceText;

    public VladViewHolder(@NonNull View itemView) {
        super(itemView);

        uiVladNiceText = itemView.findViewById(R.id.uiVladNiceText);
    }

    public void bind(VladItem object) {
        uiVladNiceText.setText("Hey " + object.getName() + ", Nice city " + object.getCity());
    }
}
