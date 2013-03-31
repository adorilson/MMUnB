
# Some param to run soproly
sdkdir = "/home/adorilson/workspace/adt-bundle-linux-x86/sdk"


# Describe the LPS
ALL_FEATURES = 'All features' # alias for all features
PLAYLIST_FEATURE = 'PLAYLIST'

core = {
    # TODO filter all these files by feature
    'srcfiles':['br/unb/mobileMedia/MMUnBActivity.java'],
    'resfiles':['values/strings.xml', 
                'values/ContextMenuOptions.xml',
                
                'layout/main.xml'
                ]
}

features = {
    PLAYLIST_FEATURE : {
        'srcfiles':['br/unb/mobileMedia/playlist/*.java',
                    
                    'br/unb/mobileMedia/core/domain/Playlist.java',
                    'br/unb/mobileMedia/core/domain/Audio.java',
                    'br/unb/mobileMedia/core/domain/AudioFormats.java',
                    'br/unb/mobileMedia/core/domain/Author.java',
                    'br/unb/mobileMedia/core/domain/MultimediaContent.java',
                    'br/unb/mobileMedia/core/domain/MultimediaRelated.java',
                    
                    'br/unb/mobileMedia/core/extractor/DefaultAudioExtractor.java',
                    'br/unb/mobileMedia/core/extractor/MediaExtractor.java',
                    
                    'br/unb/mobileMedia/util/FileUtility.java',
                    'br/unb/mobileMedia/util/MMConstants.java',
                    
                    'br/unb/mobileMedia/core/manager/Manager.java',
                    
                    'br/unb/mobileMedia/core/db/AuthorDAO.java',
                    'br/unb/mobileMedia/core/db/DBException.java',
                    'br/unb/mobileMedia/core/db/DBFactory.java',
                    'br/unb/mobileMedia/core/db/DBHelper.java',
                    'br/unb/mobileMedia/core/db/DBConstants.java',
                    'br/unb/mobileMedia/core/db/DefaultDBFactory.java',
                    'br/unb/mobileMedia/core/db/DefaultPlaylistDAO.java',
                    'br/unb/mobileMedia/core/db/DefaultAuthorDAO.java',
                    
                    'br/unb/mobileMedia/core/db/PlaylistDAO.java',
                    
                    'br/unb/mobileMedia/core/view/AudioPlayerActivity.java',
                    'br/unb/mobileMedia/core/view/AudioSelectActivity.java',
                    'br/unb/mobileMedia/core/view/AudioPlayerArrayAdapter.java',
                    
                    'br/unb/mobileMedia/core/audioPlayer/AudioPlayerList.java'
                    ],
        'resfiles':['layout/activity_audio_player.xml',
                    'layout/activity_play_list.xml',
                    'layout/activity_playlist_music_select.xml',
                    'layout/activity_playlist_editor.xml',
                    'layout/video_row_layout.xml',
                    
                    'menu/activity_audio_player.xml',
                    'menu/activity_play_list.xml',
                    'menu/activity_playlist_music_select.xml',
                    
                    'drawable-hdpi/ic_playlist.png',
                    'drawable-hdpi/ic_exit.png',
                    'drawable-mdpi/start.png',
                    'drawable-mdpi/stop.png'],
    }
}

# Describe the products
products = {
    'MMUnBFull': (ALL_FEATURES,),
    'MMPlaylist': (PLAYLIST_FEATURE,)
}
