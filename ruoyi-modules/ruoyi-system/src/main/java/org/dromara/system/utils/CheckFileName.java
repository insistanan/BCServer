package org.dromara.system.utils;

import java.nio.file.Files;
import java.nio.file.Path;

public class CheckFileName {
    public static Path checkFileName(Path path) {
        int count = 1;
        Path pathWithNumber = path;
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        String baseName = dotIndex == -1 ? fileName : fileName.substring(0, dotIndex);
        String extension = dotIndex == -1 ? "" : fileName.substring(dotIndex);

        // 当文件已存在时，添加一个编号
        while (Files.exists(pathWithNumber)) {
            String newName = baseName + "(" + count + ")" + extension;
            pathWithNumber = path.getParent().resolve(newName);
            count++;
        }
        return pathWithNumber;
    }
}
