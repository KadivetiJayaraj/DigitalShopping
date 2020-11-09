package com.example.photoprint.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoprint.Activities.Photo_Editor.Editing.EditingToolsAdapter;
import com.example.photoprint.Activities.Photo_Editor.Editing.EmojiBSFragment;
import com.example.photoprint.Activities.Photo_Editor.Editing.PropertiesBSFragment;
import com.example.photoprint.Activities.Photo_Editor.Editing.TextEditorDialogFragment;
import com.example.photoprint.Activities.Photo_Editor.Editing.ToolType;
import com.example.photoprint.Activities.Photo_Editor.ImagePickerActivity;
import com.example.photoprint.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import ja.burhanrashid52.photoeditor.OnPhotoEditorListener;
import ja.burhanrashid52.photoeditor.PhotoEditor;
import ja.burhanrashid52.photoeditor.PhotoEditorView;
import ja.burhanrashid52.photoeditor.TextStyleBuilder;
import ja.burhanrashid52.photoeditor.ViewType;

public class AddImageActivity extends AppCompatActivity implements
        OnPhotoEditorListener, EditingToolsAdapter.OnItemSelected,
        EmojiBSFragment.EmojiListener, PropertiesBSFragment.Properties {

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.imgUndo) ImageView imgUndo;
    @BindView(R.id.imgRedo) ImageView imgRedo;
    @BindView(R.id.linear_cart) LinearLayout linear_cart;
    @BindView(R.id.linear_download) LinearLayout linear_download;

    PhotoEditor mPhotoEditor;
    private PropertiesBSFragment mPropertiesBSFragment;
    private EmojiBSFragment mEmojiBSFragment;
    private RecyclerView mRvTools;
    private EditingToolsAdapter mEditingToolsAdapter = new EditingToolsAdapter(this);

    private static final String TAG = AddImageActivity.class.getSimpleName();

    private static final int REQUEST_PICK_IMAGE = 1002;
    Bitmap imageBitmap;
    PhotoEditorView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);
        ButterKnife.bind(this);

        imageView = (PhotoEditorView) findViewById(R.id.image);
        mRvTools = findViewById(R.id.rvConstraintTools);

        imageView.getSource().setImageBitmap(imageBitmap);
        handleIntentImage(imageView.getSource());


        mPropertiesBSFragment = new PropertiesBSFragment();
        mEmojiBSFragment = new EmojiBSFragment();
        mEmojiBSFragment.setEmojiListener(this);
        mPropertiesBSFragment.setPropertiesChangeListener(this);

        LinearLayoutManager llmTools = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRvTools.setLayoutManager(llmTools);
        mRvTools.setAdapter(mEditingToolsAdapter);


        mPhotoEditor = new PhotoEditor.Builder(this, imageView)
                .setPinchTextScalable(true)
                .build();

        mPhotoEditor.setOnPhotoEditorListener(this);

    }

    @OnClick(R.id.back)
    public void onBack(){
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    @OnClick(R.id.imgUndo)
    public void onUndo(){
        //imageView.undo();
    }
    @OnClick(R.id.imgRedo)
    public void onRedo(){
        //imageView.redo();
    }
    @OnClick(R.id.linear_cart)
    public void onCart(){
        Toast.makeText(this, "Item added to Cart", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.linear_download)
    public void onDownloadImage(){
        if((imageView.getSource().getDrawable() == null))
        {
            Toasty.error(this,"Please add an Image",Toasty.LENGTH_SHORT).show();

        }
        else{
            download_img();
        }
    }


    private void download_img() {
        Drawable drawable = imageView.getSource().getDrawable();
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        String ImagePath = MediaStore.Images.Media.insertImage(
                getContentResolver(),
                bitmap,
                "demo_image",
                "niuib");
        Uri URI = Uri.parse(ImagePath);
        Toast.makeText(AddImageActivity.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();
    }


    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public void pickImage() {
        startActivityForResult(new Intent(this, ImagePickerActivity.class), REQUEST_PICK_IMAGE);
        linear_download.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (permissions[0].equals(Manifest.permission.CAMERA) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            pickImage();
        }
    }

    private void setImage(String imagePath) {
        imageView.getSource().setImageBitmap(getImageFromStorage(imagePath));
    }

    private Bitmap getImageFromStorage(String path) {

        try {

            File f = new File(path);
            // First decode with inJustDecodeBounds=true to check dimensions
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            // Calculate inSampleSize
            options.inSampleSize = calculateInSampleSize(options, 512, 512);
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f), null, options);
            return b;

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return null;
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    private void handleIntentImage(ImageView source) {
        Intent intent = getIntent();
        if (intent != null) {
            String intentType = intent.getType();
            if (intentType != null && intentType.startsWith("image/")) {
                Uri imageUri = intent.getData();
                if (imageUri != null) {
                    source.setImageURI(imageUri);
                }
            }
        }
    }

    @Override
    public void onEditTextChangeListener(final View rootView, String text, int colorCode) {
        TextEditorDialogFragment textEditorDialogFragment =
                TextEditorDialogFragment.show(this, text, colorCode);
        textEditorDialogFragment.setOnTextEditorListener(new TextEditorDialogFragment.TextEditor() {
            @Override
            public void onDone(String inputText, int colorCode) {
                final TextStyleBuilder styleBuilder = new TextStyleBuilder();
                styleBuilder.withTextColor(colorCode);

                mPhotoEditor.editText(rootView, inputText, styleBuilder);
            }
        });
    }

    @Override
    public void onAddViewListener(ViewType viewType, int numberOfAddedViews) {
        Log.d(TAG, "onAddViewListener() called with: viewType = [" + viewType + "], numberOfAddedViews = [" + numberOfAddedViews + "]");
    }

    @Override
    public void onRemoveViewListener(ViewType viewType, int numberOfAddedViews) {
        Log.d(TAG, "onRemoveViewListener() called with: viewType = [" + viewType + "], numberOfAddedViews = [" + numberOfAddedViews + "]");
    }

    @Override
    public void onStartViewChangeListener(ViewType viewType) {
        Log.d(TAG, "onStartViewChangeListener() called with: viewType = [" + viewType + "]");
    }

    @Override
    public void onStopViewChangeListener(ViewType viewType) {
        Log.d(TAG, "onStopViewChangeListener() called with: viewType = [" + viewType + "]");
    }

    @Override
    public void onColorChanged(int colorCode) {
        mPhotoEditor.setBrushColor(colorCode);
    }

    @Override
    public void onOpacityChanged(int opacity) {
        mPhotoEditor.setOpacity(opacity);
    }

    @Override
    public void onBrushSizeChanged(int brushSize) {
        mPhotoEditor.setBrushSize(brushSize);
    }

    @Override
    public void onEmojiClick(String emojiUnicode) {
        mPhotoEditor.addEmoji(emojiUnicode);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_PICK_IMAGE:
                    String imagePath = data.getStringExtra("image_path");
                    setImage(imagePath);
                    break;
            }
        }
        else{
            Toast.makeText(AddImageActivity.this,"Failed to Load Image",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onToolSelected(ToolType toolType) {
        switch (toolType) {
            case BRUSH:
                mPhotoEditor.setBrushDrawingMode(true);
                mPropertiesBSFragment.show(getSupportFragmentManager(), mPropertiesBSFragment.getTag());
                break;
            case TEXT:
                TextEditorDialogFragment textEditorDialogFragment = TextEditorDialogFragment.show(this);
                textEditorDialogFragment.setOnTextEditorListener(new TextEditorDialogFragment.TextEditor() {
                    @Override
                    public void onDone(String inputText, int colorCode) {
                        final TextStyleBuilder styleBuilder = new TextStyleBuilder();
                        styleBuilder.withTextColor(colorCode);

                        mPhotoEditor.addText(inputText, styleBuilder);
                    }
                });
                break;
            case ERASER:
                mPhotoEditor.brushEraser();
                break;
            case FILTER:
                if(isPermissionGranted()){
                    pickImage();
                }else{
                    ActivityCompat.requestPermissions(AddImageActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
                }
                break;
            case EMOJI:
                mEmojiBSFragment.show(getSupportFragmentManager(), mEmojiBSFragment.getTag());
                break;
        }
    }
}