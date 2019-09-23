//
//  WeMobNativeAd.h
//  Created by Matthew on 2019/6/20.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "WeMobNativeAdDelegate.h"
#import "WeMobNativeAdLayout.h"

NS_ASSUME_NONNULL_BEGIN

@interface WeMobNativeAd : NSObject

@property(nonatomic, readonly, nonnull) NSString *adUnitId;

- (WeMobNativeAd *)initWithAdUnitId:(NSString *)adUnitId;
@property(nonatomic, weak, nullable) id<WeMobNativeAdDelegate> delegate;

- (void)setNativeAdLayout:(WeMobNativeAdLayout *)layout;
- (void)setHE;
- (void)loadAd;
- (BOOL)isReady;
- (UIView *)getAdView;
- (UIView *)getAdView:(WeMobNativeAdLayout *)layout;
- (void)destroy;

@end

NS_ASSUME_NONNULL_END
