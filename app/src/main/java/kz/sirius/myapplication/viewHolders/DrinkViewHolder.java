package kz.sirius.myapplication.viewHolders;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.Drink;

public class DrinkViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView companyName;
    private CheckBox isAlcoholic;
    private CheckBox isCarbonated;
    private CheckBox isSweet;

    public DrinkViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        companyName = itemView.findViewById(R.id.companyName);
        isAlcoholic = itemView.findViewById(R.id.isAlcoholic);
        isCarbonated = itemView.findViewById(R.id.isCarbonated);
        isSweet = itemView.findViewById(R.id.isSweet);
    }

    public void bind(Drink drink) {
        name.setText(drink.getName());
        companyName.setText(drink.getCompanyName());
        isAlcoholic.setChecked(drink.isAlcoholic());
        isCarbonated.setChecked(drink.isCarbonated());
        isSweet.setChecked((drink.isSweet()));
    }
}
