package kz.sirius.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {

    private ArrayList<Item> items = new ArrayList<>();

    void setContent(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_details2, parent, false);
        }

        Item item = items.get(position);

        convertView.findViewById(R.id.uiImage);
        TextView uiText = convertView.findViewById(R.id.uiText);
        TextView uiTextDetails = convertView.findViewById(R.id.uiTextDetails);

        uiText.setText(item.title);
        uiTextDetails.setText(item.text);

        return convertView;
    }
}
