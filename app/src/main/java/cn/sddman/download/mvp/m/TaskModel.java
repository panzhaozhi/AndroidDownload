package cn.sddman.download.mvp.m;

import java.util.List;

import cn.sddman.download.mvp.e.DownloadTaskEntity;

public interface TaskModel {
    List<DownloadTaskEntity> findAllTask();
    List<DownloadTaskEntity> findTaskByUrl(String url);
    List<DownloadTaskEntity> findTaskByHash(String hash);
    DownloadTaskEntity findTaskById(int id);
    List<DownloadTaskEntity> findLoadingTask();
    List<DownloadTaskEntity> findDowningTask();
    List<DownloadTaskEntity> findSuccessTask();
    DownloadTaskEntity upDataTask(DownloadTaskEntity task);
    Boolean deleTask(DownloadTaskEntity task);
}
