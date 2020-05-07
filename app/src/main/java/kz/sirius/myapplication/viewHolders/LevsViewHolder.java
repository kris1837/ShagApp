package kz.sirius.myapplication.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.LevsItem;

public class LevsViewHolder extends RecyclerView.ViewHolder {

    TextView uiIp;

    public LevsViewHolder(@NonNull View itemView) {
        super(itemView);

        uiIp = itemView.findViewById(R.id.uiIp);
    }

    public void bind(LevsItem object) {
        try {
            object = new LevsItem("");
            uiIp.setText("Your ip " + object.getIp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
