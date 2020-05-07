package kz.sirius.myapplication.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.AmirkhanItem;

public class AmirkhansViewHolder extends RecyclerView.ViewHolder {

    TextView uiHeaderText;
    TextView uiContentText;
    ImageView image;

    public AmirkhansViewHolder(@NonNull View itemView) {
        super(itemView);

        uiHeaderText = itemView.findViewById(R.id.uiHeaderText);
        uiContentText = itemView.findViewById(R.id.uiContentText);
    }

    public void bind(AmirkhanItem object) {
        uiHeaderText.setText(object.get_header());
        uiContentText.setText(object.get_content());
        image.setImageResource(R.drawable.ic_assignment_ind_black_24dp);
    }
}
