package ThinkBridge.Extensions;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class GenericFunctions 
{
	
	public static boolean DetectNewDownload(int PreviousDownloadCount, int CurrentDownloadCount)
    {
        if (PreviousDownloadCount < CurrentDownloadCount)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String GetLatestDownloadedFileName(File DirInfo)
    {
        File[] files = DirInfo.listFiles((dir, name) -> name.toLowerCase().endsWith(".docx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        String fileName = files[0].getName();
        return fileName;
    }

    public static String DatePickerControlDateXpath(String BaSeControlPath, String day, String CLosePath)
    {
        String DatePickerControlDateXpath1 = BaSeControlPath + day + CLosePath;
        return DatePickerControlDateXpath1;
    }

    public static int FolderFileCount(File DirInfo)
    {
        int Filecount = DirInfo.listFiles().length;
        return Filecount;   
    }

    public static String[] DateSplitter(String Dates)
    {
        String[] SplittedDate = Dates.split("/");
        return SplittedDate;
    }

}
