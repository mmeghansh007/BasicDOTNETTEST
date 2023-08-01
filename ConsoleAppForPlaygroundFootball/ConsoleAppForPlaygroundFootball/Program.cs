using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using static System.Net.Mime.MediaTypeNames;

namespace ImageMergeConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            
            string playgroundImagePath = "Playground.png";
            string footballImagePath = "Football.png";

            int totalFrames = 50;
            int yMovementPerFrame = 5;
            int delayBetweenFrames = 100;
            int repeat = 0; 

           
            Image playgroundImage = Image.FromFile(playgroundImagePath);
            Image footballImage = Image.FromFile(footballImagePath);

       
            int initialX = playgroundImage.Width / 2 - footballImage.Width / 2; 
            int initialY = playgroundImage.Height - footballImage.Height; 
            
            
            string outputDirectory = "Frames";
            Directory.CreateDirectory(outputDirectory);

            
            for (int frame = 0; frame < totalFrames; frame++)
            {
                using (var mergedImage = new Bitmap(playgroundImage))
                {
                    using (Graphics graphics = Graphics.FromImage(mergedImage))
                    {
                        
                        int currentY = initialY - (frame * yMovementPerFrame);

                        
                        graphics.DrawImage(footballImage, initialX, currentY, footballImage.Width, footballImage.Height);

                        
                        string framePath = Path.Combine(outputDirectory, $"frame_{frame}.gif");
                        mergedImage.Save(framePath, ImageFormat.Gif);
                    }
                }
            }

            
            string gifPath = "BouncingFootball.gif";
            using (var gif = new FileStream(gifPath, FileMode.Create))
            {
                using (var gifEncoder = new GifEncoder(gif))
                {
                    gifEncoder.SetDelay(delayBetweenFrames);
                    gifEncoder.SetRepeat(repeat);

                    foreach (string framePath in Directory.GetFiles(outputDirectory, "*.gif"))
                    {
                        using (var frameImage = Image.FromFile(framePath))
                        {
                            gifEncoder.AddFrame(frameImage);
                        }
                    }
                }
            }

            
            Directory.Delete(outputDirectory, true);

            Console.WriteLine("GIF animation created successfully!");
        }
    }
}