
# Some param to run soproly
sdkdir = "/home/adorilson/workspace/adt-bundle-linux-x86/sdk"

# Describe the LPS
ALL_FEATURES = 'All features' # alias for all features
PLAYLIST_FEATURE = 'PLAYLIST'
SHARE_FEATURE = 'SHARE'

core = {
    # TODO filter all these files by feature
    'srcfiles':['br/unb/mobileMedia/MMUnBActivity.java'],
    'resfiles':['values/strings.xml', 
                'values/ContextMenuOptions.xml',
                
                'layout/main.xml'
                ]
}


DEFAULT_SRC_DIR = 'br/unb/mobileMedia/'
features = {
    PLAYLIST_FEATURE : {
        'srcfiles':[DEFAULT_SRC_DIR + 'playlist/*.java',
                    
                    DEFAULT_SRC_DIR + 'core/domain/Playlist.java',
                    DEFAULT_SRC_DIR + 'core/domain/Audio.java',
                    DEFAULT_SRC_DIR + 'core/domain/AudioFormats.java',
                    DEFAULT_SRC_DIR + 'core/domain/Author.java',
                    DEFAULT_SRC_DIR + 'core/domain/MultimediaContent.java',
                    DEFAULT_SRC_DIR + 'core/domain/MultimediaRelated.java',
                    
                    DEFAULT_SRC_DIR + 'core/extractor/DefaultAudioExtractor.java',
                    DEFAULT_SRC_DIR + 'core/extractor/MediaExtractor.java',
                    
                    DEFAULT_SRC_DIR + 'util/FileUtility.java',
                    DEFAULT_SRC_DIR + 'util/MMConstants.java',
                    
                    DEFAULT_SRC_DIR + 'core/manager/Manager.java',
                    
                    DEFAULT_SRC_DIR + 'core/db/AuthorDAO.java',
                    DEFAULT_SRC_DIR + 'core/db/DBException.java',
                    DEFAULT_SRC_DIR + 'core/db/DBFactory.java',
                    DEFAULT_SRC_DIR + 'core/db/DBHelper.java',
                    DEFAULT_SRC_DIR + 'core/db/DBConstants.java',
                    DEFAULT_SRC_DIR + 'core/db/DefaultDBFactory.java',
                    DEFAULT_SRC_DIR + 'core/db/DefaultPlaylistDAO.java',
                    DEFAULT_SRC_DIR + 'core/db/DefaultAuthorDAO.java',
                    
                    DEFAULT_SRC_DIR + 'core/db/PlaylistDAO.java',
                    
                    DEFAULT_SRC_DIR + 'core/view/AudioPlayerActivity.java',
                    DEFAULT_SRC_DIR + 'core/view/AudioSelectActivity.java',
                    DEFAULT_SRC_DIR + 'core/view/AudioPlayerArrayAdapter.java',
                    
                    DEFAULT_SRC_DIR + 'core/audioPlayer/AudioPlayerList.java'
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
    },
    SHARE_FEATURE : {
        'srcfiles': [DEFAULT_SRC_DIR + 'core/view/ShareListActivity.java',],
        'resfiles': ['layout/activity_share_list.xml',
        
                      'drawable-hdpi/ic_exit.png',
                      'drawable-mdpi/twitter.png',
                      'drawable-ldpi/twitter.png',
                      'drawable-hdpi/twitter.png',
                      'drawable-hdpi/facebook.png',
                      'drawable-ldpi/facebook.png',
                      'drawable-mdpi/facebook.png',
        ],
        'libfiles': ['socialauth*']
        
    }
}

# Describe the products
products = {
    'MMUnBFull': (ALL_FEATURES,),
    'MMPlaylist': (PLAYLIST_FEATURE,),
    'MMShare': (SHARE_FEATURE,),
    'MMPlaylist_and_Share': (PLAYLIST_FEATURE, SHARE_FEATURE),
}
