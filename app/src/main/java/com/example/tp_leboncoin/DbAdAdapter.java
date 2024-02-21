package com.example.tp_leboncoin;

public class DbAdAdapter extends CursorAdapter {
    private final int item_layout;
    public DbAdAdapter(Context context, Cursor c, int layout) {
        super(context, c);
        item_layout = layout;
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(item_layout, viewGroup, false);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView idTextView = (TextView) view.findViewById(...);
        TextView titleTextView = (TextView) view.findViewById(...);
        TextView addressTextView = (TextView) view.findViewById(...);
        ImageView imageView = (ImageView) view.findViewById(...);
        String id = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper._ID));
        String title = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.TITLE));
        String address = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ADDRESS));
        String image = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.IMAGE));
        idTextView.setText(id);
        titleTextView.setText(title);
        7
        addressTextView.setText(address);
        Glide.with(view).load(image).into(imageView); \\ Glide is a library to insert an image into
        an imageview with a url.
    }
}
