package cn.sddman.download.thread;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import cn.sddman.download.listener.MagnetSearchListener;
import cn.sddman.download.mvp.e.MagnetInfo;
import cn.sddman.download.mvp.e.MagnetRule;
import cn.sddman.download.mvp.e.MagnetSearchBean;
import cn.sddman.download.mvp.m.MagnetWServiceModel;
import cn.sddman.download.mvp.m.MagnetWServiceModelImp;

public class MangetSearchTask extends AsyncTask<MagnetSearchBean, Void, List<MagnetInfo>> {
    private MagnetWServiceModel magnetWService;
    private MagnetSearchListener listener;

    public MangetSearchTask(MagnetSearchListener listener){
        this.listener=listener;
        magnetWService=new MagnetWServiceModelImp();

    }

    @Override
    protected List<MagnetInfo> doInBackground(MagnetSearchBean... parm) {
        List<MagnetInfo> infos = new ArrayList<MagnetInfo>();
        try {
            infos = magnetWService.parser(parm[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return infos;
    }
    @Override
    protected void onPostExecute(List<MagnetInfo> info) {
        listener.success(info);
       // super.onPostExecute(info);
    }
}