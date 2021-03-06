package net.filebot.cli;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.filebot.Language;
import net.filebot.RenameAction;
import net.filebot.format.ExpressionFilter;
import net.filebot.format.ExpressionFormat;
import net.filebot.hash.HashType;
import net.filebot.subtitle.SubtitleFormat;
import net.filebot.subtitle.SubtitleNaming;
import net.filebot.web.Datasource;
import net.filebot.web.SortOrder;

public interface CmdlineInterface {

	List<File> rename(Collection<File> files, RenameAction action, ConflictAction conflict, File output, ExpressionFormat format, Datasource db, String query, SortOrder order, ExpressionFilter filter, Locale locale, boolean strict) throws Exception;

	List<File> rename(Map<File, File> rename, RenameAction action, ConflictAction conflict) throws Exception;

	List<File> revert(Collection<File> files, FileFilter filter, RenameAction action) throws Exception;

	List<File> getSubtitles(Collection<File> files, String query, Language language, SubtitleFormat output, Charset encoding, SubtitleNaming format, boolean strict) throws Exception;

	List<File> getMissingSubtitles(Collection<File> files, String query, Language language, SubtitleFormat output, Charset encoding, SubtitleNaming format, boolean strict) throws Exception;

	boolean check(Collection<File> files) throws Exception;

	File compute(Collection<File> files, File output, HashType hash, Charset encoding) throws Exception;

	List<String> fetchEpisodeList(Datasource db, String query, ExpressionFormat format, ExpressionFilter filter, SortOrder order, Locale locale) throws Exception;

	List<String> getMediaInfo(Collection<File> files, FileFilter filter, ExpressionFormat format) throws Exception;

	List<File> extract(Collection<File> files, File output, ConflictAction conflict, FileFilter filter, boolean forceExtractAll) throws Exception;

}
