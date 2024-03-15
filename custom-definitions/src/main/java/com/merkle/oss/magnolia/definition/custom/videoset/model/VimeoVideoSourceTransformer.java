package com.merkle.oss.magnolia.definition.custom.videoset.model;

import com.merkle.oss.magnolia.definition.custom.videoset.VideoType;
import com.merkle.oss.magnolia.definition.custom.videoset.VideoTypes;
import com.merkle.oss.magnolia.definition.custom.videoset.VimeoTextValueConverter;
import com.merkle.oss.magnolia.definition.custom.videoset.model.VideoModel.VideoSource;
import com.merkle.oss.magnolia.definition.custom.videoset.model.VideoModel.VideoSourceTransformer;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Optional;

public class VimeoVideoSourceTransformer implements VideoSourceTransformer {

	@Override
	public boolean test(final VideoType videoType) {
		return VideoTypes.VIMEO.equals(videoType);
	}

	@Override
	public Optional<VideoSource> transform(final Locale locale, final String src) {
		if (StringUtils.startsWith(src, VimeoTextValueConverter.PREFIX)) {
			return Optional.of(new VideoSource(StringUtils.removeStart(src, VimeoTextValueConverter.PREFIX)));
		}
		return Optional.empty();
	}
}
