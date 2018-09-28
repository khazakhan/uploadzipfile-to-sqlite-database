package info.whats_online.sqlitedbwithimages;

        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.io.ByteArrayInputStream;
        import java.io.InputStream;
        import java.util.ArrayList;
        import java.util.zip.ZipInputStream;

/**
 * Visit website http://www.whats-online.info
 * **/

public class dataAdapter extends ArrayAdapter<Contact>{

    Context context;
    ArrayList<Contact> mcontact;


    public dataAdapter(Context context, ArrayList<Contact> contact){
        super(context, R.layout.listcontacts, contact);
        this.context=context;
        this.mcontact=contact;
    }

    public  class  Holder{
        TextView nameFV;
        ImageView pic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        Contact data = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        Holder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {


            viewHolder = new Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listcontacts, parent, false);

            viewHolder.nameFV = (TextView) convertView.findViewById(R.id.txtViewer);
            viewHolder.pic = (ImageView) convertView.findViewById(R.id.imgView);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Holder) convertView.getTag();
        }


        viewHolder.nameFV.setText("First Name: "+data.getFName());
        //viewHolder.pic.setImageBitmap(convertToBitmap(data.getImage()));


        // Return the completed view to render on screen
        return convertView;
    }
    //get bitmap image from byte array

    private Bitmap convertToBitmap(byte[] b){

        InputStream is = new ByteArrayInputStream(b);
        InputStream zis = new ZipInputStream(is);

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }


    //Code related to convert the zip file then byte[]
    /*private byte [] StreamFile(string filename)
    {
        FileStream fs = new FileStream(filename, FileMode.Open,FileAccess.Read);

        // Create a byte array of file stream length
        byte[] ImageData = new byte[fs.Length];

        //Read block of bytes from stream into the byte array
        fs.Read(ImageData,0,System.Convert.ToInt32(fs.Length));

        //Close the File Stream
        fs.Close();
        return ImageData; //return the byte data
    }*/

}

