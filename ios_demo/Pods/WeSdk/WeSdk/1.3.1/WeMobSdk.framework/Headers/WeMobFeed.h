//
//  WeMobFeed.h
//  WeMobSdk
//
//  Created by Matthew on 2019/9/19.
//  Copyright © 2019年 WeMob. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "WeMobNativeAdLayout.h"
@class WeMobCustomFeedList<T>;

typedef NS_ENUM(NSUInteger, WeMobFeedType) {
    WEMOB_FEEDTYPE_UNKNOWN = 0, // 未知类型
    WEMOB_FEEDTYPE_LARGE_IMAGE = 1, // 大图
    WEMOB_FEEDTYPE_SMALL_IMAGE = 2, // 小图
    WEMOB_FEEDTYPE_VERTICAL_IMAGE = 3, // 竖图
    WEMOB_FEEDTYPE_GROUP_IMAGE = 4, // 组图
    WEMOB_FEEDTYPE_VIDEO = 5  // 视频
};

@interface WeMobFeed<T> : NSObject 

- (WeMobFeed<T> *)initWithAdapter:(WeMobCustomFeedList<T> *)adapter feed:(T)feed;
- (WeMobFeedType)getType;
- (UIView *)getAdView:(WeMobNativeAdLayout *)layout;

@end
