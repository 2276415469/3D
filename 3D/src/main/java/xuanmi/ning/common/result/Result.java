package xuanmi.ning.common.result;

public class Result {
    private boolean success;
    private String message;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.success = true;
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.success = true;
        result.data = data;
        return result;
    }

    public static Result success(String message, Object data) {
        Result result = new Result();
        result.success = true;
        result.message = message;
        result.data = data;
        return result;
    }

    public static Result failure(String message) {
        Result result = new Result();
        result.success = false;
        result.message = message;
        return result;
    }

    public static Result failure(String message, Object data) {
        Result result = new Result();
        result.success = false;
        result.message = message;
        result.data = data;
        return result;
    }
}
