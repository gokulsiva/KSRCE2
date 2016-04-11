package in.ac.ksrce.ksrce2;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import android.widget.Toast;
import android.webkit.MimeTypeMap;
/**
 * Created by gokul on 24-01-2016.
 */
public class Download_Content {


    private long myDownloadReference;
    private String downloadFileUrl;
    private String downloadFileName;
    private BroadcastReceiver receiverDownloadComplete;
    private BroadcastReceiver receiverNotificationClicked;
    Context context;
    SessionManagement session;

    public Download_Content(Context context,String url,String filename) {
        this.context = context;
        downloadFileUrl = url;
        downloadFileName = filename;
        session = new SessionManagement(context);
        session.userDetails();
        downloader();
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void downloader() {
        File exstngfile = new File(Environment.getExternalStorageDirectory() + "/ksrce/"+session.username+"/" + downloadFileName);

        if (!exstngfile.exists()) {

            File directory = new File(Environment.getExternalStorageDirectory() + "/ksrce/"+session.username);
            if (!directory.exists()) {
                directory.mkdir();
            }
            String userAccount = session.user_account;
            if(userAccount.equals("Staff"))
            {
                Update_circularviewed update = new Update_circularviewed(context);
                update.updateStaff(downloadFileName);
            }
            DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(downloadFileUrl);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setDescription("Sdcard/ksrce/"+session.username+"/" + downloadFileName).setTitle(downloadFileName);
            request.setDestinationInExternalPublicDir("/ksrce/"+session.username, downloadFileName);
            request.setNotificationVisibility(1);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
            myDownloadReference = downloadManager.enqueue(request);

            IntentFilter filter1 = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
            receiverDownloadComplete = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    long reference = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                    if (myDownloadReference == reference) {
                        // Do something with downloaded file.
                        Toast.makeText(context, "Download completed check in Notification", Toast.LENGTH_LONG).show();
                    }
                }
            };
            context.registerReceiver(receiverDownloadComplete, filter1);

            IntentFilter filter = new IntentFilter(DownloadManager.ACTION_NOTIFICATION_CLICKED);
            receiverNotificationClicked = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    String extraId = DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS;
                    long[] references = intent.getLongArrayExtra(extraId);
                    for (long reference : references) {
                        if (reference == myDownloadReference) {
                            openFile(downloadFileName);

                        }
                    }

                }
            };
            context.registerReceiver(receiverNotificationClicked, filter);


        }
        else
        {
            Toast.makeText(context,"File already exists check in Downloads",Toast.LENGTH_LONG).show();
        }
    }

    private void openFile(String file_name) {
        String path = Environment.getDataDirectory().toString()+"/ksrce/"+session.username+"/";
        File file = new File(path, file_name);
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        int index = file.getName().lastIndexOf('.')+1;
        String ext = file.getName().substring(index).toLowerCase();
        String type = mime.getMimeTypeFromExtension(ext);

        try {

            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), type);
            context.startActivity(intent);


        } catch (android.content.ActivityNotFoundException e) {
            Toast.makeText(context,"No app found to open this file", Toast.LENGTH_LONG).show();
        }
    }

}
