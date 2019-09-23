//
//  WeMobBannerAd.h
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "WeMobTypes.h"
#import "WeMobBannerViewDelegate.h"
#import "WeMobBannerAdPosition.h"
#import "WeMobILineItem.h"

NS_ASSUME_NONNULL_BEGIN

@interface WeMobBannerView : UIView

@property(nonatomic, readonly) NSString *adUnitId;

/// iOS Start
- (id)initWithAdUnitId:(NSString *)adUnitId rootViewController:(UIViewController *)viewController;
@property(nonatomic, weak) id<WeMobBannerViewDelegate> delegate;
/// iOS End

/// Unity Start
- (id)initWithBannerClientReference:(WeMobTypeBannerClientRef _Nullable* _Nullable)bannerClient adUnitId:(NSString *)adUnitId rootViewController:(UIViewController *)viewController;
// 引用 Unity 的 BannerClient
@property(nonatomic, assign) WeMobTypeBannerClientRef _Nullable* _Nullable bannerClient;
// 广告加载后，回调到 Unity 的接口
@property(nonatomic, assign) WeMobBannerAdDidReceiveAdCallback adReceivedCallback;
@property(nonatomic, assign) WeMobBannerAdDidFailToReceiveAdWithErrorCallback adFailedCallback;
@property(nonatomic, assign) WeMobBannerAdWillPresentScreenCallback willPresentCallback;
@property(nonatomic, assign) WeMobBannerAdDidDismissScreenCallback didDismissCallback;
@property(nonatomic, assign) WeMobBannerAdWillLeaveApplicationCallback willLeaveCallback;
/// Unity End

- (void)setHE;
- (BOOL)isReady;
- (void)destroy;

/// iOS Start
- (void)loadAd;
/// iOS End

/// Unity Start
- (void)loadAdUnity;

- (void)showUnity:(WeMobBannerAdPosition)position;
- (void)showUnityWithX:(int)x andY:(int)y;

- (void)showUnity:(WeMobBannerAdPosition)position inNetworks:(nonnull int[])networkIds;
- (void)showUnityWithX:(int)x andY:(int)y inNetworks:(nonnull int[])networkIds;

- (void)setUnityPosition:(WeMobBannerAdPosition)position;
- (void)setUnityPositionWithX:(int)x andY:(int)y;

- (void)hideUnity;

- (void)removeUnity;
/// Unity End

@end
NS_ASSUME_NONNULL_END
