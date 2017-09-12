package ren.daxu.architecture.data;

import android.support.annotation.NonNull;

import com.google.common.base.Objects;

import java.util.UUID;

public final class TaskData {

    private Object data;

    @NonNull
    private final String mId;

    @NonNull
    private final String mTitle;

    @NonNull
    private final String mDescription;

    public TaskData(String id, String title, String description) {
        this.mId = id;
        this.mTitle = title;
        this.mDescription = description;
    }

    public TaskData(String title, String description) {
        this(UUID.randomUUID().toString(), title, description);
    }

    public void setData(Object data){
        this.data = data;
    }

    public Object getData(){
        return data;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskData task = (TaskData) o;
        return Objects.equal(mId, task.mId) &&
                Objects.equal(mTitle, task.mTitle) &&
                Objects.equal(mDescription, task.mDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mId, mTitle, mDescription);
    }

    @Override
    public String toString() {
        return "TaskData with title " + mTitle;
    }


}
