package lljk.xtrace.traceOption.match;

/**
 * @Description TODO
 * @Date 2019/3/17
 * @Author fangan
 **/
public class DefaultClassFileTransformMatch implements ClassFileTransformMatch{

    public boolean isLoadClass(String name) {
        return false;
    }
}
