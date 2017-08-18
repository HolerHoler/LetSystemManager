package com.let.function;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface IExcelService {
	 InputStream getExcelInputStream(String sheelName, String[] headerName,
			List list) throws IOException;// ·µ»Ø
}
