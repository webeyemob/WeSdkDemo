//
//  WeMobRewardedVideoAd.h
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "WeMobTypes.h"
#import "WeMobRewardedVideoAdDelegate.h"
#import "WeMobInnerRewardedVideoAdDelegate.h"

NS_ASSUME_NONNULL_BEGIN

// WeMobInnerRewardedVideoAdDelegate 必须在这里声明
@interface WeMobRewardedVideoAd : NSObject<WeMobInnerRewardedVideoAdDelegate>

@property(nonatomic, readonly) NSString *adUnitId;

/// iOS Start
- (id)initWithAdUnitId:(NSString *)adUnitId;
@property(nonatomic, weak, nullable) id<WeMobRewardedVideoAdDelegate> delegate;
/// iOS End

/// Unity Start
- (id)initWithRewardedVideoClientReference:(WeMobTypeRewardedVideoClientRef _Nullable* _Nullable)rewardedVideoClient adUnitId:(NSString *)adUnitId;
@property(nonatomic, assign) WeMobTypeRewardedVideoClientRef _Nullable *_Nullable rewardedVideoClient;
/// The ad callback into Unity.
@property(nonatomic, assign, nullable) WeMobRewardVideoDidReceiveAdCallback didReceivedCallback;
@property(nonatomic, assign, nullable) WeMobRewardVideoDidOpenCallback didOpenCallback;
@property(nonatomic, assign, nullable) WeMobRewardVideoWillLeaveApplicationCallback willLeaveCallback;
@property(nonatomic, assign, nullable) WeMobRewardVideoDidCloseCallback didCloseCallback;
@property(nonatomic, assign, nullable) WeMobRewardVideoDidFailToReceiveAdWithErrorCallback didFailToReceiveAdCallback;
@property(nonatomic, assign, nullable) WeMobRewardVideoDidStartCallback didStartCallback;
@property(nonatomic, assign, nullable) WeMobRewardVideoDidCompleteCallback didCompleteCallback;
@property(nonatomic, assign, nullable) WeMobRewardVideoDidRewardCallback didRewardCallback;
@property(nonatomic, assign, nullable) WeMobRewardVideoDidFailedToRewardCallback didFailedToRewardCallback;
/// Unity End

- (void)setHE;
- (void)setCL:(int)cacheCount;
- (void)loadAd;
- (BOOL)isReady;
- (void)destroy;

/// iOS Start
- (void)showFromViewController:(nullable UIViewController *)viewController;
/// iOS End

/// Unity Start
- (void)showUnity;
- (void)showUnity:(nullable int [])networkIds;
/// Unity End

NS_ASSUME_NONNULL_END

@end
