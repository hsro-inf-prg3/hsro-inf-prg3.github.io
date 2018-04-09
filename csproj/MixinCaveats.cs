using System;

namespace MixinCaveats {
    interface Escalatable {
        string Text { get; }
    }
    class Message : Escalatable {
        public string Text { get; set; }

        public string Escalated1() => Text.ToLower();
    
        public void Sophisticated1(object o) {
            Console.WriteLine("Message: {0}", o.GetType());
        }
        public void Sophisticated2(int i) {
            Console.WriteLine("Message: {0}", i.GetType());
        }
    }
    
    static class MessageMixins {
        public static string Escalated1(this Escalatable self) 
            => self.Text.ToUpper();
        
        public static void Sophisticated1(this Message self, int i)
            => Console.WriteLine("Mixin: {0}", i);

        public static void Sophisticated2(this Message self, object o) 
            => Console.WriteLine("Mixin: {0}", o);
    }

    class Program {
        static void Main(string[] args) {
            Message m = new Message();
            m.Text = "Hello, world";

            Console.WriteLine(m.Escalated1());  // oops! Message.Escalated1
            Console.WriteLine((m as Escalatable).Escalated1());  // ah!

            // watch out with automatic type conversion
            m.Sophisticated1(1);
            m.Sophisticated1("Hans");

            m.Sophisticated2(1);
            m.Sophisticated2("Hans");
        }
    }
}