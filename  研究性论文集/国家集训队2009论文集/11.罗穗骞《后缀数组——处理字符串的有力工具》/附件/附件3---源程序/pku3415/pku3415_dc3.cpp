#include "stdio.h"
#include "string.h"
#define maxn 200004

#define F(x) ((x)/3+((x)%3==1?0:tb))
#define G(x) ((x)<tb?(x)*3+1:((x)-tb)*3+2)
int wa[maxn],wb[maxn],wv[maxn],ws[maxn];
int c0(int *r,int a,int b)
{return r[a]==r[b]&&r[a+1]==r[b+1]&&r[a+2]==r[b+2];}
int c12(int k,int *r,int a,int b)
{if(k==2) return r[a]<r[b]||r[a]==r[b]&&c12(1,r,a+1,b+1);
 else return r[a]<r[b]||r[a]==r[b]&&wv[a+1]<wv[b+1];}
void sort(int *r,int *a,int *b,int n,int m)
{
     int i;
     for(i=0;i<n;i++) wv[i]=r[a[i]];
     for(i=0;i<m;i++) ws[i]=0;
     for(i=0;i<n;i++) ws[wv[i]]++;
     for(i=1;i<m;i++) ws[i]+=ws[i-1];
     for(i=n-1;i>=0;i--) b[--ws[wv[i]]]=a[i];
     return;
}
void dc3(int *r,int *sa,int n,int m)
{
     int i,j,*rn=r+n,*san=sa+n,ta=0,tb=(n+1)/3,tbc=0,p;
     r[n]=r[n+1]=0;
     for(i=0;i<n;i++) if(i%3!=0) wa[tbc++]=i;
     sort(r+2,wa,wb,tbc,m);
     sort(r+1,wb,wa,tbc,m);
     sort(r,wa,wb,tbc,m);
     for(p=1,rn[F(wb[0])]=0,i=1;i<tbc;i++)
     rn[F(wb[i])]=c0(r,wb[i-1],wb[i])?p-1:p++;
     if(p<tbc) dc3(rn,san,tbc,p);
     else for(i=0;i<tbc;i++) san[rn[i]]=i;
     for(i=0;i<tbc;i++) if(san[i]<tb) wb[ta++]=san[i]*3;
     if(n%3==1) wb[ta++]=n-1;
     sort(r,wb,wa,ta,m);
     for(i=0;i<tbc;i++) wv[wb[i]=G(san[i])]=i;
     for(i=0,j=0,p=0;i<ta && j<tbc;p++)
     sa[p]=c12(wb[j]%3,r,wa[i],wb[j])?wa[i++]:wb[j++];
     for(;i<ta;p++) sa[p]=wa[i++];
     for(;j<tbc;p++) sa[p]=wb[j++];
     return;
}
int rank[maxn],height[maxn];
void calheight(int *r,int *sa,int n)
{
     int i,j,k=0;
     for(i=1;i<=n;i++) rank[sa[i]]=i;
     for(i=0;i<n;height[rank[i++]]=k)
     for(k?k--:0,j=sa[rank[i]-1];r[i+k]==r[j+k];k++);
     return;
}

int r[maxn*3],sa[maxn*3];
char s[maxn];
int f[maxn];
int a[maxn],b[maxn],c;
long long ss,ans;
int main()
{
    int i,k,l,n,t;
    scanf("%d",&k);
    while(k!=0)
    {
      scanf("%s",s);
      l=strlen(s);
      s[l]=1;
      scanf("%s",s+l+1);
      n=strlen(s);
      for(i=0;i<n;i++) r[i]=s[i];
      r[n]=0;
      dc3(r,sa,n+1,128);
      calheight(r,sa,n);
      for(i=2;i<=n;i++)
      {
        f[i]=sa[i]<l;
        height[i]-=k-1;
        if(height[i]<0) height[i]=0;
      }
      height[n+1]=0;
      a[0]=-1;ans=0;
      for(t=0;t<=1;t++)
      for(c=0,ss=0,i=2;i<=n;i++)
      {
        if(f[i]!=t) ans+=ss;
        c++;
        a[c]=height[i+1];
        b[c]=f[i]==t;
        ss+=(long long)a[c]*b[c];
        while(a[c-1]>=a[c])
        {
          ss-=(long long)(a[c-1]-a[c])*b[c-1];
          a[c-1]=a[c];
          b[c-1]+=b[c];
          c--;
        }
      }
      printf("%I64d\n",ans);
      scanf("%d",&k);
    }
    return 0;
}
