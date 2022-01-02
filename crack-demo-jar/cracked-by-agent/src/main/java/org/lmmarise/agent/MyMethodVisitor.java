package org.lmmarise.agent;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

/**
 * @author lmmarise.j@gmail.com
 * @since 2022/1/2 9:48 PM
 */
public class MyMethodVisitor extends AdviceAdapter {

    protected MyMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(api, methodVisitor, access, name, descriptor);
    }

    @Override
    protected void onMethodEnter() {
        mv.visitInsn(ICONST_1);
        mv.visitInsn(IRETURN);
    }
}
