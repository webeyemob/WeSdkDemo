//
//  WeMobFeedList.h
//  WeMobSdk
//
//  Created by Matthew on 2019/9/18.
//  Copyright © 2019年 WeMob. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "WeMobFeedListDelegate.h"
#import "WeMobNativeAdLayout.h"
#import "WeMobFeed.h"

@interface WeMobFeedList : NSObject

@property(nonatomic, readonly, nonnull) NSString *adUnitId;

- (WeMobFeedList *)initWithAdUnitId:(NSString *)adUnitId;
@property(nonatomic, weak, nullable) id<WeMobFeedListDelegate> delegate;

- (void)setCount:(int)count;
- (void)setHE;
- (void)loadAd;
- (BOOL)isReady;
- (NSMutableArray<WeMobFeed *> *)getFeedArray;
- (void)destroy;

@end
