package org.lmmarise.agent;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author lmmarise.j@gmail.com
 * @since 2022/1/2 10:46 PM
 */
public class MyClassVisitor extends ClassVisitor {
    public MyClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM9, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (name.equals("canLoad")) {
            return new MyMethodVisitor(Opcodes.ASM9, mv, access, name, descriptor);
        }
        return mv;
    }
}
