package kz.sirius.myapplication.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.EntityYernar;

public class ViewHolderYernar extends RecyclerView.ViewHolder {
    private TextView txtName;
    private TextView txtDesc;

    ViewHolderYernar(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtDesc = itemView.findViewById(R.id.txtDesc);
    }

    public void bind(EntityYernar entity){
        txtName.setText(entity.getName());
        txtDesc.setText(entity.getDescription());
    }
}
