package ren.daxu.architecture.example.api;

import java.util.List;

public class TestResponse extends BaseRespose<List<TestResponse.TestData>> {


    public static class TestData {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public List<ImageData> imageDatas;

        public List<ImageData> getImageDatas() {
            return imageDatas;
        }

        public void setImageDatas(List<ImageData> imageDatas) {
            this.imageDatas = imageDatas;
        }
    }

    public static class ImageData {
        private String src;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }

}
