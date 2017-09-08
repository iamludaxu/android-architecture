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
    }

}
