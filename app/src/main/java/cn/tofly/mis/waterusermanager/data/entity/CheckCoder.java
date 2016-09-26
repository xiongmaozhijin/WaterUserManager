package cn.tofly.mis.waterusermanager.data.entity;

import java.util.List;

/**
 * Created by hasee on 2016/9/26.
 */
public class CheckCoder {

    @Override
    public String toString() {
        return "CheckCoder{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 1
     * message : 获取成功
     * data : {"total":4,"rows":[{"code":"01","name":"生活"},{"code":"02","name":"集体"},{"code":"03","name":"营业"},{"code":"04","name":"工业"}]}
     */



    private int code;
    private String message;
    /**
     * total : 4
     * rows : [{"code":"01","name":"生活"},{"code":"02","name":"集体"},{"code":"03","name":"营业"},{"code":"04","name":"工业"}]
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        @Override
        public String toString() {
            return "DataBean{" +
                    "total=" + total +
                    ", rows=" + rows +
                    '}';
        }

        private int total;
        /**
         * code : 01
         * name : 生活
         */

        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {

            @Override
            public String toString() {
                return "RowsBean{" +
                        "code='" + code + '\'' +
                        ", name='" + name + '\'' +
                        '}';
            }

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
