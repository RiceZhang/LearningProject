package com.zrx.junit4.rules;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * TemporaryFolder {@link Rule} 会允许你在执行测试方法完成后，把你在测试方法中删除的文件或文件夹 重新创建
 * 
 * @author zrx
 * @date 2017年9月9日
 */
public class HasTempFolder {
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFile = folder.newFile("myfile.txt");
        File createdFolder = folder.newFolder("subfolder");
    }
}
