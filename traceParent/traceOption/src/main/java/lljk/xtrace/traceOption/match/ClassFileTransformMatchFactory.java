package lljk.xtrace.traceOption.match;

/**
 * @Description TODO
 * @Date 2019/3/17
 * @Author fangan
 **/
public class ClassFileTransformMatchFactory {
    private ClassFileTransformMatchFactory(){

    }
    private static ClassFileTransformMatchFactory classFileTransformMatchFactory;

    public static ClassFileTransformMatchFactory getClassFileTransformMatch(){

            if (classFileTransformMatchFactory != null){
                return classFileTransformMatchFactory;
            }else{
                synchronized (ClassFileTransformMatchFactory.class){
                    if(classFileTransformMatchFactory != null){
                        return classFileTransformMatchFactory;
                    }else{
                        classFileTransformMatchFactory =
                                new ClassFileTransformMatchFactory();
                        return classFileTransformMatchFactory;
                    }
                }
            }

    }



}
