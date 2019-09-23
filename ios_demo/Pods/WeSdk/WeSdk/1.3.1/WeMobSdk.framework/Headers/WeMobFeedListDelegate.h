//
//  WeMobFeedListDelegate.h
//
//  Created by Matthew on 2019/9/18.
//  Copyright © 2019年 WeMob. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "WeMobAdError.h"
@class WeMobFeedList;

@protocol WeMobFeedListDelegate<NSObject>

@optional
- (void)weMobFeedListDidReceiveAd:(WeMobFeedList *)feedList;

@optional
- (void)weMobFeedList:(WeMobFeedList *)feedList didFailToReceiveAdWithError:(WeMobAdError *)adError;

@optional
- (void)weMobFeedListWillPresentScreen:(WeMobFeedList *)feedList;

@optional
- (void)weMobFeedListDidDismissScreen:(WeMobFeedList *)feedList;

@optional
- (void)weMobFeedListWillLeaveApplication:(WeMobFeedList *)feedList;

@end
